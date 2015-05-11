package com.prototype.enumdata;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ExcelValidationDataTest {
    @Test
    public void testGetHeaderIndexByName() throws Exception {
        // given
        int expected = 1;
        String headName = "카테고리";
        // when
        int actual = ExcelValidationData.getHeaderIndexByName(headName);

        // then
        assertThat(actual, is(expected));
    }

    @Test
    public void testGetHeaderNameByIndex() throws Exception {
        // given
        String expected = "카테고리";

        // when
        String actual = ExcelValidationData.getHeaderNameByIndex(1);

        // then
        assertThat(actual, is(expected));
    }

    @Test
    public void testGetHeaderSize() throws Exception {
        // given
        int expected = 52;

        // when
        int actual = ExcelValidationData.getHeaderSize();

        // then
        assertThat(actual, is(expected));
    }

    @Test
    public void testGetSetMethodNameByIndex() throws Exception {
        // given
        int headerIndex = 1;
        String expected = "setCategoryId";

        // when
        String actual = ExcelValidationData.getSetMethodNameByIndex(headerIndex);

        // then
        assertThat(actual, is(expected));
    }

    @Test
    public void testGetGetMethodNameByIndex() throws Exception {
        // given
        int headerIndex = 1;
        String expected = "getCategoryId";

        // when
        String actual = ExcelValidationData.getGetMethodNameByIndex(headerIndex);

        // then
        assertThat(actual, is(expected));
    }

    @Test
    public void testGetHeaderTypeByIndex() throws Exception {
        // given
        int headerIndex = 1;
        ExcelValidationData expected = ExcelValidationData.CATEGORY_ID;

        // when
        ExcelValidationData actual = ExcelValidationData.getHeaderTypeByIndex(headerIndex);

        // then

        assertThat(actual, is(expected));

    }
}