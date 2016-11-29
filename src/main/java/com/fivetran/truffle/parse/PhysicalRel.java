package com.fivetran.truffle.parse;

import com.fivetran.truffle.compile.RowSource;
import com.fivetran.truffle.compile.ThenRowSink;
import org.apache.calcite.plan.Convention;
import org.apache.calcite.rel.RelNode;

/**
 * Relational expression that uses the Truffle calling convention.
 * Calling convention is a Calcite concept; Calcite produces a logical query plan (for example LogicalProject)
 * which we convert into a physical query plan (for example PhysicalProject).
 */
public interface PhysicalRel extends RelNode {
    /**
     * Compile into an executable Truffle expression
     */
    RowSource compile(ThenRowSink next);

    /** Calling convention for Truffle expressions files */
    Convention CONVENTION = new Convention.Impl("TRUFFLE", PhysicalRel.class);
}
