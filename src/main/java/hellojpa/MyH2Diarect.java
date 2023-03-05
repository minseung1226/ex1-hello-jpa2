package hellojpa;

import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class MyH2Diarect extends H2Dialect {

    public MyH2Diarect() {
        registerFunction("group_concat",new StandardSQLFunction("group_concat", StandardBasicTypes.STRING));
    }
}
