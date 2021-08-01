package com.naichuan.service.impl;

import com.naichuan.entity.PlanWork;
import com.naichuan.service.PlanWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

/**
 * @author Naichuan Zhang
 */
@Service
public class PlanWorkServiceImpl implements PlanWorkService {

    @Autowired
    private JdbcTemplate template;

    @Autowired
    private SimpleDateFormat sdf;

    @Override
    public int savePlanWork(PlanWork planWork) {
        String sql = "insert into plan_work (plan_id, plan_content, plan_title, plan_creator, plan_to, " +
                "plan_createtime, plan_updatetime, plan_flag, plan_updater, plan_priority," +
                " plan_complexity, plan_start, plan_end) " +
                "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return template.update(sql, planWork.getPlanId(), planWork.getPlanContent(), planWork.getPlanTitle(), planWork.getPlanCreator(), planWork.getPlanTo(),
                planWork.getPlanCreatetime(), planWork.getPlanUpdatetime(), planWork.getPlanFlag(), planWork.getPlanUpdater(), planWork.getPlanPriority(),
                planWork.getPlanComplexity(), planWork.getPlanStart(), planWork.getPlanEnd());
    }

    @Override
    public List<PlanWork> selectPlanWorkByCreatorPaging(String username, Optional<Integer> page, Optional<Integer> offset) {
        String sql = "select * from plan_work where plan_creator = ?" +
                " order by plan_createtime desc limit ?, ?";
        int pageNumber = page.orElse(0);
        int offsetNumber = offset.orElse(7);
        return template.query(sql, new BeanPropertyRowMapper<>(PlanWork.class),
                username, pageNumber, offsetNumber);
    }

    @Override
    public long selectPlanWorkCountByCreator(String username) {
        String sql = "select count(*) as count from plan_work where plan_creator = ?";
        return (long) template.queryForMap(sql, username).get("count");
    }

    @Override
    public long selectPlanToCountProcessing(String username) {
        String sql = "select count(*) as count from plan_work where plan_to = ? and plan_flag = 1";
        return (long) template.queryForMap(sql, username).get("count");
    }

    @Override
    public long selectPlanToCountNonProcessing(String username) {
        String sql = "select count(*) as count from plan_work where plan_to = ? and plan_flag <> 1";
        return (long) template.queryForMap(sql, username).get("count");
    }

    @Override
    public List<PlanWork> selectByPlanTo(String username, PlanWork.PlanFlag flag, Optional<Integer> page, Optional<Integer> offset) {
        String sql = "select * from plan_work pw left join sys_login sl on sl.username = pw.plan_creator" +
                " where pw.plan_to = ? and pw.plan_flag = ? order by pw.plan_createtime desc limit ?, ?";
        int pageNumber = page.orElse(0);
        int offsetNumber = offset.orElse(7);
        return template.query(sql, new BeanPropertyRowMapper<>(PlanWork.class),
                username, flag.getValue(), pageNumber, offsetNumber);
    }

    @Override
    public List<PlanWork> selectByPlanToFlagExclusive(String username, PlanWork.PlanFlag flag, Optional<Integer> page, Optional<Integer> offset) {
        String sql = "select * from plan_work pw left join sys_login sl on sl.username = pw.plan_creator" +
                " where pw.plan_to = ? and pw.plan_flag <> ? order by pw.plan_createtime desc limit ?, ?";
        int pageNumber = page.orElse(0);
        int offsetNumber = offset.orElse(7);
        return template.query(sql, new BeanPropertyRowMapper<>(PlanWork.class),
                username, flag.getValue(), pageNumber, offsetNumber);
    }

    @Override
    public PlanWork selectById(String id) {
        String sql = "select * from plan_work where plan_id = ?";
        return template.queryForObject(sql, PlanWork.class, id);
    }

    @Override
    public int update(String id, PlanWork.PlanFlag flag) {
        String sql = "update plan_work set plan_flag = ?, plan_updatetime = current_timestamp where plan_id = ?";
        return template.update(sql, flag, id);
    }
}
