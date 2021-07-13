package com.lw.constants;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/31
 * @Description: com.lw.constants
 * @version: 1.0
 * <p>
 * 业务枚举类
 */
public class Constants {

    /**
     * 产品组合状态
     */
    public enum ProductAssembleStatusEnum {

        SINGLE(0, "单品"),
        ASSEMBLE(1, "组合"),
        GIFTS(2, "礼包");

        private Integer key;
        private String msg;

        ProductAssembleStatusEnum(Integer key, String msg) {
            this.key = key;
            this.msg = msg;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    /**
     * 产品组合状态
     */
    public enum ProductAssembleTypeEnum {

        SINGLE("单品"),
        GIFTS("礼包");

        private String key;

        ProductAssembleTypeEnum(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    /**
     * 产品分类枚举
     */
    public enum classifyEnum {

        PRODUCT("product", "产品分类"),
        FINANCE("finance", "财务分类"),
        HARDWARE("hardware", "五金劳保分类"),
        MARKET("market", "超市分类"),
        GROUPBUY("groupBuy", "团购分类"),
        GOODS("goods", "归口物资分类"),
        ALLVIEW("allView", "云造总览分类");

        private String key;
        private String msg;

        classifyEnum(String key, String msg) {
            this.key = key;
            this.msg = msg;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    public enum CodeTypeEnum {

        /**
         * 财务编码
         */
        FINANCIAL_CODE(1),

        /**
         * 产品条形码
         */
        PRODUCT_BAR_CODE(2);

        private Integer key;

        CodeTypeEnum(Integer key) {
            this.key = key;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }
    }

    /**
     * 销售bom版本类型枚举
     */
    public enum ProductAssembleVersionEnum {

        /**
         * 常规版本
         */
        COMMON(1),
        /**
         * 替代版本
         */
        PERLACE(2);

        private int key;

        ProductAssembleVersionEnum(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }
    }


}
