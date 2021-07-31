package com.naichuan.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 任务计划表
 * @TableName plan_work
 */
@Data
public class PlanWork implements Serializable {
    /**
     * 
     */
    private String planId;

    /**
     * 
     */
    private String planContent;

    /**
     * 
     */
    private String planTitle;

    /**
     * 
     */
    private String planCreator;

    /**
     * 
     */
    private String planTo;

    /**
     * 
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date planCreatetime;

    /**
     * 
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date planUpdatetime;

    /**
     * 审批状态
     */
    private String planFlag;

    /**
     * 
     */
    private String planUpdater;

    /**
     * 
     */
    private Integer planPriority;

    /**
     * 
     */
    private Integer planComplexity;

    /**
     * 
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date planStart;

    /**
     * 
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date planEnd;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PlanWork other = (PlanWork) that;
        return (this.getPlanId() == null ? other.getPlanId() == null : this.getPlanId().equals(other.getPlanId()))
            && (this.getPlanContent() == null ? other.getPlanContent() == null : this.getPlanContent().equals(other.getPlanContent()))
            && (this.getPlanTitle() == null ? other.getPlanTitle() == null : this.getPlanTitle().equals(other.getPlanTitle()))
            && (this.getPlanCreator() == null ? other.getPlanCreator() == null : this.getPlanCreator().equals(other.getPlanCreator()))
            && (this.getPlanTo() == null ? other.getPlanTo() == null : this.getPlanTo().equals(other.getPlanTo()))
            && (this.getPlanCreatetime() == null ? other.getPlanCreatetime() == null : this.getPlanCreatetime().equals(other.getPlanCreatetime()))
            && (this.getPlanUpdatetime() == null ? other.getPlanUpdatetime() == null : this.getPlanUpdatetime().equals(other.getPlanUpdatetime()))
            && (this.getPlanFlag() == null ? other.getPlanFlag() == null : this.getPlanFlag().equals(other.getPlanFlag()))
            && (this.getPlanUpdater() == null ? other.getPlanUpdater() == null : this.getPlanUpdater().equals(other.getPlanUpdater()))
            && (this.getPlanPriority() == null ? other.getPlanPriority() == null : this.getPlanPriority().equals(other.getPlanPriority()))
            && (this.getPlanComplexity() == null ? other.getPlanComplexity() == null : this.getPlanComplexity().equals(other.getPlanComplexity()))
            && (this.getPlanStart() == null ? other.getPlanStart() == null : this.getPlanStart().equals(other.getPlanStart()))
            && (this.getPlanEnd() == null ? other.getPlanEnd() == null : this.getPlanEnd().equals(other.getPlanEnd()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPlanId() == null) ? 0 : getPlanId().hashCode());
        result = prime * result + ((getPlanContent() == null) ? 0 : getPlanContent().hashCode());
        result = prime * result + ((getPlanTitle() == null) ? 0 : getPlanTitle().hashCode());
        result = prime * result + ((getPlanCreator() == null) ? 0 : getPlanCreator().hashCode());
        result = prime * result + ((getPlanTo() == null) ? 0 : getPlanTo().hashCode());
        result = prime * result + ((getPlanCreatetime() == null) ? 0 : getPlanCreatetime().hashCode());
        result = prime * result + ((getPlanUpdatetime() == null) ? 0 : getPlanUpdatetime().hashCode());
        result = prime * result + ((getPlanFlag() == null) ? 0 : getPlanFlag().hashCode());
        result = prime * result + ((getPlanUpdater() == null) ? 0 : getPlanUpdater().hashCode());
        result = prime * result + ((getPlanPriority() == null) ? 0 : getPlanPriority().hashCode());
        result = prime * result + ((getPlanComplexity() == null) ? 0 : getPlanComplexity().hashCode());
        result = prime * result + ((getPlanStart() == null) ? 0 : getPlanStart().hashCode());
        result = prime * result + ((getPlanEnd() == null) ? 0 : getPlanEnd().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", planId=").append(planId);
        sb.append(", planContent=").append(planContent);
        sb.append(", planTitle=").append(planTitle);
        sb.append(", planCreator=").append(planCreator);
        sb.append(", planTo=").append(planTo);
        sb.append(", planCreatetime=").append(planCreatetime);
        sb.append(", planUpdatetime=").append(planUpdatetime);
        sb.append(", planFlag=").append(planFlag);
        sb.append(", planUpdater=").append(planUpdater);
        sb.append(", planPriority=").append(planPriority);
        sb.append(", planComplexity=").append(planComplexity);
        sb.append(", planStart=").append(planStart);
        sb.append(", planEnd=").append(planEnd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Getter
    @AllArgsConstructor
    public enum PlanFlag {
        FLAG_PROCESSING(1),
        FLAG_AGREED(2),
        FLAG_REJECTED(3);

        private int value;
        private static Map<Integer, PlanFlag> map = new HashMap<>();

        static {
            for (PlanFlag flag : PlanFlag.values()) {
                map.put(flag.value, flag);
            }
        }

        public static PlanFlag valueOf(int value) {
            return map.get(value);
        }
    }
}