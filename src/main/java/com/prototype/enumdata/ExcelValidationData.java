package com.prototype.enumdata;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by runner on 15. 5. 11.
 */
public enum ExcelValidationData {
    CATEGORY_ID("categoryId", "카테고리", 1),
    PRODUCT_NAME("productName", "상품명", 2),
    SALE_STARTED_AT("saleStartedAt", "요청시작일", 3),
    SALE_ENDED_AT("saleEndedAt", "요청종료일", 4),
    MANUFACTURE("manufacture", "제조사", 5),
    BRAND("브랜드", "brand", 6),
    ATTRIBUTE_TYPE_1("attributeType1", "속성타입1", 7),
    ATTRIBUTE_VALUE_1("attributeValue1", "속성값1", 8),
    ATTRIBUTE_TYPE_2("attributeType2", "속성타입2", 9),
    ATTRIBUTE_VALUE_2("attributeValue2", "속성값2", 10),
    ATTRIBUTE_TYPE_3("attributeType3", "속성타입3", 11),
    ATTRIBUTE_VALUE_3("attributeValue3", "속성값3", 12),
    ATTRIBUTE_TYPE_4("attributeType4", "속성타입4", 13),
    ATTRIBUTE_VALUE_4("attributeValue4", "속성값4", 14),
    SALE_AGENT_COMMISSION_TYPE("saleAgentCommissionType", "수수료방식", 15),
    SALE_PRICE("salePrice", "판매가격", 16),
    SALE_AGENT_COMMISSION("saleAgentCommission", "판매대행수수료", 17),
    SUPPLY_PRICE("supplyPrice", "지급가", 18),
    ORIGINAL_PRICE("originalPrice", "할인률기준가", 19),
    MAXIMUM_BUY_COUNT("maximumBuyCount", "초기수량", 20),
    UNIT_COUNT("unitCount", "단위수량", 21),
    GET_MAXIMUM_BUY_FOR_PERSON("getMaximumBuyForPerson", "주문당판매수량", 22),
    TAX_TYPE("taxType", "과세여부", 23),
    PARALLEL_IMPORTED("parallelImported", "병행수입여부", 24),
    OVERSEAS_PURCHASED("overseasPurchased", "해외구매대행", 25),
    EXTERNAL_VENDOR_SKU_CODE("externalVendorSkuCode", "업체상품코드", 26),
    BARCODE("barcode", "바코드", 27),
    MODEL_NO("modelNo", "모델번호", 28),
    NOTICE_CATEGORY_ID("noticeCategoryId", "상품필수정보 카테고리", 29),
    NOTICE_CATEGORY_VALUE_1("noticeCategoryValue1", "상품필수정보값1", 30),
    NOTICE_CATEGORY_VALUE_2("noticeCategoryValue2", "상품필수정보값2", 31),
    NOTICE_CATEGORY_VALUE_3("noticeCategoryValue3", "상품필수정보값3", 32),
    NOTICE_CATEGORY_VALUE_4("noticeCategoryValue4", "상품필수정보값4", 33),
    NOTICE_CATEGORY_VALUE_5("noticeCategoryValue5", "상품필수정보값5", 34),
    NOTICE_CATEGORY_VALUE_6("noticeCategoryValue6", "상품필수정보값6", 35),
    NOTICE_CATEGORY_VALUE_7("noticeCategoryValue7", "상품필수정보값7", 36),
    NOTICE_CATEGORY_VALUE_8("noticeCategoryValue8", "상품필수정보값8", 37),
    NOTICE_CATEGORY_VALUE_9("noticeCategoryValue9", "상품필수정보값9", 38),
    NOTICE_CATEGORY_VALUE_10("noticeCategoryValue10", "상품필수정보값10", 39),
    NOTICE_CATEGORY_VALUE_11("noticeCategoryValue11", "상품필수정보값11", 40),
    NOTICE_CATEGORY_VALUE_12("noticeCategoryValue12", "상품필수정보값12", 41),
    NOTICE_CATEGORY_VALUE_13("noticeCategoryValue13", "상품필수정보값13", 42),
    NOTICE_CATEGORY_VALUE_14("noticeCategoryValue14", "상품필수정보값14", 43),
    ITEM_IMAGE_PC("itemImagePC", "대표이미지 PC용", 44),
    ITEM_IMAGE_MOBILE("itemImageMobile", "대표이미지 모바일용", 45),
    ITEM_IMAGE_ETC("itemImageEtc", "기타이미지", 46),
    ITEM_DETAIL_DESCRIPTION("itemDetailDescription", "상세 설명", 47),
    REQUIRED_DOCUMENT_VALUE_1("requiredDocumentValue1", "구비서류값1", 48),
    REQUIRED_DOCUMENT_VALUE_2("requiredDocumentValue2", "구비서류값2", 49),
    REQUIRED_DOCUMENT_VALUE_3("requiredDocumentValue3", "구비서류값3", 50),
    REQUIRED_DOCUMENT_VALUE_4("requiredDocumentValue4", "구비서류값4", 51),
    REQUIRED_DOCUMENT_VALUE_5("requiredDocumentValue5", "구비서류값5", 52);

    public static final int EXCEL_DATA_FIRST_ROW = 4;
    public static final int EXCEL_DATA_MAX_ROW = 1004;

    private final String headerCode;
    private final String headerName;
    private final int headerIndex;

    private static final Map<String, Integer> headerCodeIndex = new TreeMap<>();
    private static final Map<String, Integer> headerNameIndex = new TreeMap<>();
    private static final Map<Integer, ExcelValidationData> headerIndexWithData = new TreeMap<>();

    private ExcelValidationData(String headerCode, String headerName, int headerIndex) {
        this.headerCode = headerCode;
        this.headerName = headerName;
        this.headerIndex = headerIndex;

        HeaderIndexMap.headerCodeIndex.put(headerCode, headerIndex);
        HeaderIndexMap.headerNameIndex.put(headerName, headerIndex);
        HeaderIndexMap.headerIndexWithData.put(headerIndex, this);
    }



    private static class HeaderIndexMap
    {
        private static final Map<String, Integer> headerCodeIndex = new TreeMap<>();
        private static final Map<String, Integer> headerNameIndex = new TreeMap<>();
        private static final Map<Integer, ExcelValidationData> headerIndexWithData = new TreeMap<>();
    }

    public static int getHeaderIndexByName(String headerName) {
        return HeaderIndexMap.headerNameIndex.get(headerName);
    }

    public static String getHeaderNameByIndex(int index) {
        return HeaderIndexMap.headerIndexWithData.get(index).headerName;
    }

    public static int getHeaderSize() {
        return values().length;
    }

    public static String getSetMethodNameByIndex(int headerIndex) {
        ExcelValidationData excelValidationData = HeaderIndexMap.headerIndexWithData.get(headerIndex);
        String headerfieldName = excelValidationData.headerCode;
        return ExcelValidationDataHelper.getSetMethodName(headerfieldName);
    }

    public static String getGetMethodNameByIndex(int headerIndex) {
        ExcelValidationData excelValidationData = HeaderIndexMap.headerIndexWithData.get(headerIndex);
        String headerfieldName = excelValidationData.headerCode;
        return ExcelValidationDataHelper.getGetMethodName(headerfieldName);
    }

    public static ExcelValidationData getHeaderTypeByIndex(int headerIndex) {
        return HeaderIndexMap.headerIndexWithData.get(headerIndex);
    }

}
