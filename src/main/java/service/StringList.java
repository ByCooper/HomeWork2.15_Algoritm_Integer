package service;

import exception.NotFoundElementException;
import exception.NullValueFindException;
import exception.OutsideSelectException;
import object.Repository;

import java.util.Arrays;

public class StringList implements ServiceStringList{
    Repository repository = new Repository();

    @Override
    public String add(String item) {
        String[] rep = new String[repository.length() + 1];
        System.arraycopy(repository.getRepository(), 0, rep, 0, repository.length());
        rep[rep.length - 1] = item;
        repository.setRepository(rep);
        return repository.getRepository()[rep.length - 1];
    }

    @Override
    public String add(int index, String item) {
        String[] rep = new String[repository.length() + 1];
        if (index > rep.length - 1) {
            throw new OutsideSelectException("Вы выбрали индекс, который находится за пределами массива");
        } else if (index == 0) {
            System.arraycopy(repository.getRepository(), 0, rep, 1, repository.length());
            rep[index] = item;
            repository.setRepository(rep);
        } else {
            System.arraycopy(repository.getRepository(), 0, rep, 0, index);
            rep[index] = item;
            System.arraycopy(repository.getRepository(), index, rep, index + 1, repository.length() - index);
            repository.setRepository(rep);
        }
        return repository.getRepository()[index];
    }

    @Override
    public String set(int index, String item) {
        String[] rep = new String[repository.length()];
        if (index > rep.length - 1) {
            throw new OutsideSelectException("Вы выбрали индекс, который находится за пределами массива");
        } else if (index == 0) {
            System.arraycopy(repository.getRepository(), 1, rep, 1, repository.length() - (index + 1));
            rep[index] = item;
            repository.setRepository(rep);
        } else {
            System.arraycopy(repository.getRepository(), 0, rep, 0, index);
            rep[index] = item;
            System.arraycopy(repository.getRepository(), index + 1, rep, index + 1, repository.length() - (index + 1));
            repository.setRepository(rep);
        }
        return repository.getRepository()[index];
    }

    @Override
    public String remove(String item) {
        int index = Integer.MIN_VALUE;
        String[] rep = new String[repository.length() - 1];
        for (int i = 0; i < repository.length(); i++) {
            if (item.equals(repository.getRepository()[i])) {
                index = i;
            }
        }
        if (index < 0) {
            throw new NotFoundElementException("Элемент не найден");
        }
        else if (index == 0) {
            System.arraycopy(repository.getRepository(), 1, rep, 0, repository.length() - 1);
            repository.setRepository(rep);
        } else {
            System.arraycopy(repository.getRepository(), 0, rep, 0, index);
            System.arraycopy(repository.getRepository(), index + 1, rep, index, repository.length() - (index + 1));
            repository.setRepository(rep);
        }
        return "Элемент " + item + " удален";
    }

    @Override
    public String remove(int index) {
        if (index > repository.getRepository().length - 1) {
            throw new OutsideSelectException("Вы выбрали индекс, который находится за пределами массива");
        }
        String[] rep = new String[repository.length() - 1];
        String remove = repository.getRepository()[index];
        if (index == 0) {
            System.arraycopy(repository.getRepository(), 1, rep, 0, repository.length() - 1);
            repository.setRepository(rep);
        } else {
            System.arraycopy(repository.getRepository(), 0, rep, 0, index);
            System.arraycopy(repository.getRepository(), index + 1, rep, index, repository.length() - (index + 1));

            repository.setRepository(rep);
        }
        return "Элемент " + remove + " удален";
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < repository.length(); i++) {
            if (repository.getRepository()[i] == null) {
                throw new NullValueFindException("В списке недопустимое значение=null");
            }
            else if(repository.getRepository()[i].equals(item)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < repository.length(); i++) {
            if(repository.getRepository()[i].equals(item)){
                int index;
                return index = i;
            }
        }
        return - 1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = repository.length() - 1; i >= 0; i--) {
            if(repository.getRepository()[i].equals(item)){
                int index;
                return index = i;
            }
        }
        return - 1;
    }

    @Override
    public String get(int index) {
        if (index > repository.getRepository().length - 1) {
            throw new OutsideSelectException("Вы выбрали индекс, который находится за пределами массива");
        }
        return repository.getRepository()[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        otherList.contains(null);
        String[] rep = new String[otherList.size()];
        for (int i = 0; i < otherList.size(); i++) {
            rep[i] = otherList.get(i);
        }
        if (Arrays.equals(repository.getRepository(), rep)) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return repository.length();
    }

    @Override
    public boolean isEmpty() {
        if (repository.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        String[] rep = new String[0];
        repository.setRepository(rep);
    }

    @Override
    public String[] toArray() {
        String[] rep = new String[repository.length()];
        System.arraycopy(repository.getRepository(), 0, rep, 0, repository.length());
        return rep;
    }
}
