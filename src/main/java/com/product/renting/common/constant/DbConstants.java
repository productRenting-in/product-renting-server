package com.product.renting.common.constant;

public class DbConstants {

    // Auditing column names
    public static final String CREATED_ON = "created_on";
    public static final String UPDATED_ON = "updated_on";

    // Database table names
    public static final String CATEGORY = "category";
    public static final String PRODUCT = "product";
    public static final String PRODUCT_PRICING = "product_pricing";
    public static final String INVENTORY_ITEM = "inventory_item";
    public static final String INVENTORY_RESERVATION = "inventory_reservation";

    // Column names for category table
    public static final String CATEGORY_ID = "category_id";
    public static final String CATEGORY_NAME = "category_name";
    public static final String CATEGORY_DESCRIPTION = "category_description";
    public static final String CATEGORY_SLUG = "category_slug";

    // Column names for product table
    public static final String PRODUCT_ID = "product_id";
    public static final String PRODUCT_NAME = "product_name";
    public static final String PRODUCT_DESCRIPTION = "product_description";
    public static final String TRACKING_TYPE = "tracking_type";

    // Column names for product_pricing table
    public static final String PRODUCT_PRICING_ID = "product_pricing_id";
    public static final String PRICE_PER_DAY = "price_per_day";
    public static final String PRICE_PER_WEEK = "price_per_week";
    public static final String PRICE_PER_MONTH = "price_per_month";
    public static final String PRODUCT_PRICING_EFFECTIVE_FROM = "product_pricing_effective_from";
    public static final String PRODUCT_PRICING_EFFECTIVE_TO = "product_pricing_effective_to";

    // Column names for inventory_item table
    public static final String INVENTORY_ITEM_ID = "inventory_item_id";
    public static final String INVENTORY_ITEM_SERIAL_NUMBER = "inventory_item_serial_number";
    public static final String INVENTORY_ITEM_STATUS = "inventory_item_status";
    public static final String INVENTORY_ITEM_QUANTITY = "inventory_item_quantity";

    // Column names for inventory_reservation table
    public static final String INVENTORY_RESERVATION_ID = "inventory_reservation_id";
    public static final String INVENTORY_RESERVATION_FROM_DATE = "inventory_reservation_from_date";
    public static final String INVENTORY_RESERVATION_TO_DATE = "inventory_reservation_to_date";
    public static final String INVENTORY_RESERVATION_TYPE = "inventory_reservation_type";
    public static final String INVENTORY_RESERVATION_STATUS = "inventory_reservation_status";
    public static final String RESERVED_QUANTITY = "reserved_quantity";
}
