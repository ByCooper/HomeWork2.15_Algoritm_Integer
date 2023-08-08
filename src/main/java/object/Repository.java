package object;

import java.util.Arrays;

public class Repository {
    private String[] repository = new String[0];
    public Repository() {
        this.repository = getRepository();
    }

    public String[] getRepository() {
        return repository;
    }

    public int length() {
        return repository.length;
    }

    public void setRepository(String[] repository) {
        this.repository = repository;
    }

    @Override
    public String toString() {
        return Arrays.toString(repository);
    }
}
