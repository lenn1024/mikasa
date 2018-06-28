package ai.code.mikasa.filter;

import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;

import java.util.*;
import java.util.stream.Collectors;

public class MethodFilter extends Filter {

    private Set<String> excludeMethods = new HashSet<>();

    public MethodFilter(String... excludeMethods) {
        List<String> list = Arrays.stream(excludeMethods).collect(Collectors.toList());
        this.excludeMethods.addAll(list);
    }

    @Override
    public boolean shouldRun(Description description) {
        if(excludeMethods.contains(description.getMethodName())){
            //System.out.println(description.getMethodName());
            return false;
        }
        return true;
    }

    @Override
    public String describe() {
        return null;
    }
}
