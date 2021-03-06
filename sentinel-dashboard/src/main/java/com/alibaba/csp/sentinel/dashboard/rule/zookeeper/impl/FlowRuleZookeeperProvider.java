package com.alibaba.csp.sentinel.dashboard.rule.zookeeper.impl;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.zookeeper.AbstractZookeeperRuleProvider;
import com.alibaba.csp.sentinel.dashboard.util.RuleUtils;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description Zookeeper规则查询类
 * @author: cc
 * @Date: 2019-03-04
 */

@Service("flowRuleZookeeperProvider")
public class FlowRuleZookeeperProvider extends AbstractZookeeperRuleProvider<FlowRuleEntity> {


    @Override
    protected List<FlowRuleEntity> getRuleEntityDecoders(String app, String ip, int port, String rules) {
        List<FlowRule> ruleZ = RuleUtils.parseFlowRule(rules);
        if (rules != null) {
            return ruleZ.stream().map(rule -> FlowRuleEntity.fromFlowRule(app, ip, port, rule))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }
}
