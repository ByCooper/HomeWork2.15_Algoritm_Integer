package object;

import java.util.Arrays;

public class Repository {
    private Integer[] repository = new Integer[0];
    public Repository() {
        this.repository = getRepository();
    }

    public Integer[] getRepository() {
        return repository;
    }

    public int length() {
        return repository.length;
    }

    public void setRepository(Integer[] repository) {
        this.repository = repository;
    }

    @Override
    public String toString() {
        return Arrays.toString(repository);
    }
}
