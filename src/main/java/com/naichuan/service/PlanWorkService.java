package com.naichuan.service;

import com.naichuan.entity.PlanWork;

import java.util.List;
import java.util.Optional;

public interface PlanWorkService {

    int savePlanWork(PlanWork planWork);

    List<PlanWork> selectPlanWorkByCreatorPaging(String username, Optional<Integer> page, Optional<Integer> offset);

    long selectPlanWorkCountByCreator(String username);

    long selectPlanToCountProcessing(String username);

    long selectPlanToCountNonProcessing(String username);

    List<PlanWork> selectByPlanTo(String username, PlanWork.PlanFlag flag, Optional<Integer> page, Optional<Integer> offset);

    List<PlanWork> selectByPlanToFlagExclusive(String username, PlanWork.PlanFlag flag, Optional<Integer> page, Optional<Integer> offset);

    PlanWork selectById(String id);

    int update(String id, PlanWork.PlanFlag flag);
}
