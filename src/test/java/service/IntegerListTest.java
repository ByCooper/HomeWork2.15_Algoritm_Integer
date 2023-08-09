package service;

import exception.NotFoundElementException;
import exception.NullValueFindException;
import exception.OutsideSelectException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListTest {
    IntegerList actualList = new IntegerList();
    IntegerList expectedList = new IntegerList();
    @Test
    void addSucces() {
        //Подготовка входных данных
        Integer actual = actualList.add(700);
        //Подготовка ожидаемого результата
        Integer expected = 700;
        //Начало теста
        assertEquals(expected, actual);
    }
    @Test
    void addSuccesIndex() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(23);
        actualList.add(59);
        Integer actual = actualList.add(2,700);
        //Подготовка ожидаемого результата
        Integer expected = 700;
        expectedList.add(18);
        expectedList.add(23);
        expectedList.add(expected);
        expectedList.add(59);
        //Начало теста
        assertEquals(expected, actual);
        assertEquals(expectedList.repository.toString(), actualList.repository.toString());
    }
    @Test
    void addExceptionIndex() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(23);
        actualList.add(59);
        Exception exception = assertThrows(OutsideSelectException.class, () -> {
            actualList.add(4,700);
        });
        //Подготовка ожидаемого результата
        String expectedMessage = "Вы выбрали индекс, который находится за пределами массива";
        //Начало теста
        assertEquals(expectedMessage, exception.getMessage());
    }
    @Test
    void set() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(23);
        actualList.add(59);
        Integer actual = actualList.set(1, 700);
        //Подготовка ожидаемого результата
        expectedList.add(18);
        expectedList.add(700);
        expectedList.add(59);
        Integer expected = 700;
        //Начало теста
        assertEquals(expected, actual);
        assertEquals(expectedList.repository.toString(), actualList.repository.toString());
    }
    @Test
    void setEcxeption() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(23);
        actualList.add(59);
        Exception exception = assertThrows(OutsideSelectException.class, () ->{
            actualList.set(3, 700);
        });
        Integer actual = actualList.set(1, 700);
        //Подготовка ожидаемого результата
        String expectedMessage = "Вы выбрали индекс, который находится за пределами массива";
        //Начало теста
        assertEquals(expectedMessage, exception.getMessage());
    }
    @Test
    void remove() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(23);
        actualList.add(59);
        Integer actual = actualList.remove(23);
        //Подготовка ожидаемого результата
        Integer expected = 23;
        expectedList.add(18);
        expectedList.add(59);
        //Начало теста
        assertEquals(expected, actual);
        assertEquals(expectedList.repository.toString(), actualList.repository.toString());
    }
    @Test
    void removeException() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(23);
        actualList.add(59);
        Exception exception = assertThrows(NotFoundElementException.class, () -> {
            actualList.remove(700);
        });
        //Подготовка ожидаемого результата
        String expectedMessage = "Элемент не найден";
        //Начало теста
        assertEquals(expectedMessage, exception.getMessage());
    }
    @Test
    void removeIndex() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(23);
        actualList.add(59);
        Integer actual = actualList.removeIndex(2);
        //Подготовка ожидаемого результата
        Integer expected = 59;
        expectedList.add(18);
        expectedList.add(23);
        //Начало теста
        assertEquals(expected, actual);
        assertEquals(expectedList.repository.toString(), actualList.repository.toString());
    }
    @Test
    void removeIndexException() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(23);
        actualList.add(59);
        Exception exception = assertThrows(OutsideSelectException.class, () -> {
            actualList.removeIndex(3);
        });
        //Подготовка ожидаемого результата
        String expectedMessage = "Вы выбрали индекс, который находится за пределами массива";
        //Начало теста
        assertEquals(expectedMessage, exception.getMessage());
    }
    @Test
    void contains() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(23);
        actualList.add(59);
        boolean actual = actualList.contains(23);
        //Начало теста
        assertTrue(actual);
    }
    @Test
    void containsException() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(null);
        actualList.add(59);
        Exception exception = assertThrows(NullValueFindException.class, () -> {
            actualList.contains(null);
        });
        //Подготовка ожидаемого результата
        String expectedMessage = "В списке недопустимое значение=null";
        //Начало теста
        assertEquals(expectedMessage, exception.getMessage());
    }
    @Test
    void indexOfSuccess() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(23);
        actualList.add(59);
        int actual = actualList.indexOf(59);
        //Подготовка ожидаемого результата
        int expected = 2;
        //Начало теста
        assertEquals(expected, actual);
    }
    @Test
    void indexOfNegative() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(23);
        actualList.add(59);
        int actual = actualList.indexOf(700);
        //Подготовка ожидаемого результата
        int expected = - 1;
        //Начало теста
        assertEquals(expected, actual);
    }
    @Test
    void lastIndexOfSuccess() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(23);
        actualList.add(59);
        int actual = actualList.indexOf(59);
        //Подготовка ожидаемого результата
        int expected = 2;
        //Начало теста
        assertEquals(expected, actual);
    }
    @Test
    void lastIndexOfNegative() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(23);
        actualList.add(59);
        int actual = actualList.indexOf(700);
        //Подготовка ожидаемого результата
        int expected = - 1;
        //Начало теста
        assertEquals(expected, actual);
    }
    @Test
    void getSuccess() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(23);
        actualList.add(59);
        Integer actual = actualList.get(1);
        //Подготовка ожидаемого результата
        Integer expected = 23;
        //Начало теста
        assertEquals(expected, actual);
    }
    @Test
    void getException() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(23);
        actualList.add(59);
        Exception exception = assertThrows(OutsideSelectException.class, () -> {
            actualList.get(3);
        });
        //Подготовка ожидаемого результата
        String expectedMessage = "Вы выбрали индекс, который находится за пределами массива";
        //Начало теста
        assertEquals(expectedMessage, exception.getMessage());
    }
    @Test
    void testEqualsTrue() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(23);
        actualList.add(59);
        //Подготовка ожидаемого результата
        expectedList.add(18);
        expectedList.add(23);
        expectedList.add(59);
        //Начало теста
        assertTrue(expectedList.equals(actualList));
    }
    @Test
    void testEqualsFalse() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(23);
        actualList.add(59);
        //Подготовка ожидаемого результата
        expectedList.add(700);
        expectedList.add(23);
        expectedList.add(59);
        //Начало теста
        assertFalse(expectedList.equals(actualList));
    }
    @Test
    void size() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(23);
        actualList.add(59);
        int actual = actualList.size();
        //Подготовка ожидаемого результата
        int expected = 3;
        //Начало теста
        assertEquals(expected, actual);
    }
    @Test
    void isEmptyTrue() {
        //Начало теста
        assertTrue(actualList.isEmpty());
    }
    @Test
    void isEmptyFalse() {
        //Подготовка входных данных
        actualList.add(23);
        //Начало теста
        assertFalse(actualList.isEmpty());
    }
    @Test
    void clear() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(23);
        actualList.add(59);
        actualList.clear();
        int actual = actualList.size();
        //Подготовка ожидаемого результата
        int expected = expectedList.size();
        //Начало теста
        assertEquals(expected, actual);
    }
    @Test
    void toArray() {
        //Подготовка входных данных
        actualList.add(18);
        actualList.add(23);
        actualList.add(59);
        Integer[] actual = actualList.toArray();
        //Подготовка ожидаемого результата
        expectedList.add(18);
        expectedList.add(23);
        expectedList.add(59);
        Integer[] expected = expectedList.toArray();
        //Начало теста
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortedBubble() {
        //Подготовка входных данных
        actualList.add(181);
        actualList.add(230);
        actualList.add(59);
        Integer[] actual = actualList.sortedBubble(actualList.toArray());
        //Подготовка ожидаемого результата
        expectedList.add(59);
        expectedList.add(181);
        expectedList.add(230);
        Integer[] expected = expectedList.toArray();
        //Начало теста
        assertArrayEquals(expected, actual);
    }@Test
    void sortedSelection() {
        //Подготовка входных данных
        actualList.add(181);
        actualList.add(230);
        actualList.add(59);
        Integer[] actual = actualList.sortedSelection(actualList.toArray());
        //Подготовка ожидаемого результата
        expectedList.add(59);
        expectedList.add(181);
        expectedList.add(230);
        Integer[] expected = expectedList.toArray();
        //Начало теста
        assertArrayEquals(expected, actual);
    }@Test
    void sortedInsert() {
        //Подготовка входных данных
        actualList.add(181);
        actualList.add(230);
        actualList.add(59);
        Integer[] actual = actualList.sortedInsert(actualList.toArray());
        //Подготовка ожидаемого результата
        expectedList.add(59);
        expectedList.add(181);
        expectedList.add(230);
        Integer[] expected = expectedList.toArray();
        //Начало теста
        assertArrayEquals(expected, actual);
    }
}