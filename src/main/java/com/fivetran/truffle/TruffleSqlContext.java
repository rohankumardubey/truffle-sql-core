package com.fivetran.truffle;

import com.oracle.truffle.api.ExecutionContext;
import com.oracle.truffle.api.TruffleLanguage;

import java.io.*;

public class TruffleSqlContext extends ExecutionContext {
    public final BufferedReader in;
    public final PrintWriter out, err;

    public static TruffleSqlContext fromEnv(TruffleLanguage.Env env) {
        return new TruffleSqlContext(env.in(), env.out(), env.err());
    }

    public static TruffleSqlContext fromStreams(InputStream in, OutputStream out, OutputStream err) {
        return new TruffleSqlContext(in, out, err);
    }

    private TruffleSqlContext(InputStream in, OutputStream out, OutputStream err) {
        this.in = new BufferedReader(new InputStreamReader(in));
        this.out = new PrintWriter(out, true);
        this.err = new PrintWriter(err, true);
    }
}
