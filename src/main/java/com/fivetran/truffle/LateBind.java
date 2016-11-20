package com.fivetran.truffle;

/**
 * Allows us to compile a parent expression, then compile its child, then bind the child to the parent.
 */
interface LateBind {
    void bind(LazyRowSink next);
}
