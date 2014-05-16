/* @java.file.header */

/*  _________        _____ __________________        _____
 *  __  ____/___________(_)______  /__  ____/______ ____(_)_______
 *  _  / __  __  ___/__  / _  __  / _  / __  _  __ `/__  / __  __ \
 *  / /_/ /  _  /    _  /  / /_/ /  / /_/ /  / /_/ / _  /  _  / / /
 *  \____/   /_/     /_/   \_,__/   \____/   \__,_/  /_/   /_/ /_/
 */

package org.gridgain.grid.kernal.visor.cmd;

import org.gridgain.grid.*;
import org.gridgain.grid.compute.*;
import org.gridgain.grid.kernal.*;
import org.gridgain.grid.logger.*;
import org.gridgain.grid.resources.*;
import org.jetbrains.annotations.*;

/**
 * Base class for Visor job intended to query data from a single node.
 *
 * @param <T> Task argument type.
 * @param <R> Task result type.
 */
public abstract class VisorOneNodeJob<T extends VisorOneNodeArg, R> extends GridComputeJobAdapter {
    @GridInstanceResource
    protected GridKernal g;

    /** */
    @GridLoggerResource
    protected GridLogger log;

    /**
     * Create job with specified argument.
     *
     * @param arg Job argument.
     */
    protected VisorOneNodeJob(T arg) {
        super(arg);
    }

    @Nullable @Override public Object execute() throws GridException {
        T arg = argument(0);

        return run(arg);
    }

    /**
     * Execution logic of concrete task.
     *
     * @return Result.
     */
    protected abstract R run(T arg);
}
