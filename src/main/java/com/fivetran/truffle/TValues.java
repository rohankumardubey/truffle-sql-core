package com.fivetran.truffle;

import com.google.common.collect.ImmutableList;
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.plan.RelOptCost;
import org.apache.calcite.plan.RelOptPlanner;
import org.apache.calcite.plan.RelTraitSet;
import org.apache.calcite.rel.core.Values;
import org.apache.calcite.rel.metadata.RelMetadataQuery;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rex.RexLiteral;

public class TValues extends Values implements TRel {
    protected TValues(RelOptCluster cluster,
                      RelDataType rowType,
                      ImmutableList<ImmutableList<RexLiteral>> tuples,
                      RelTraitSet traits) {
        super(cluster, rowType, tuples, traits);
    }

    @Override
    public RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {
        return super.computeSelfCost(planner, mq);
    }

    @Override
    public RowSource compile() {
        return new RelLiteral(this);
    }
}