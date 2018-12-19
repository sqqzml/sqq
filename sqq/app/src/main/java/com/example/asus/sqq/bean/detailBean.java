package com.example.asus.sqq.bean;

public class detailBean {
    /**
     * msg :
     * seller : {"description":"鎴戞槸鍟嗗18","icon":"http://120.27.23.105/images/icon.png","name":"鍟嗗18","productNums":999,"score":5,"sellerid":18}
     * code : 0
     * data : {"bargainPrice":111.99,"createtime":"2017-10-14T21:39:05","detailUrl":"https://item.m.jd.com/product/4719303.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t9004/210/1160833155/647627/ad6be059/59b4f4e1N9a2b1532.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7504/338/63721388/491286/f5957f53/598e95f1N7f2adb87.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7441/10/64242474/419246/adb30a7d/598e95fbNd989ba0a.jpg!q70.jpg","itemtype":1,"pid":2,"price":299,"pscid":1,"salenum":999,"sellerid":18,"subhead":"姣忎釜涓閮戒笉鑳界畝鍗曪紝鏃犺韬湪浣曞锛屼綘鎬婚渶瑕佷竴鍧楅ゼ璁╃敓娲绘洿鍦嗘弧锛屼含涓滄湀楗艰鐖辨洿鍦嗘弧浜笢鑷惀锛岄棯鐢甸厤閫侊紝鏇村鎯婂枩锛屽揩鐢ㄦ墜鎸囨埑涓€涓?,"title":"鍖椾含绋婚鏉?绋婚鏉戜腑绉嬭妭鏈堥ゼ 鑰佸寳浜湀楗肩ぜ鐩?55g"}
     */

    private String msg;
    private SellerBean seller;
    private String code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SellerBean getSeller() {
        return seller;
    }

    public void setSeller(SellerBean seller) {
        this.seller = seller;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class SellerBean {
        /**
         * description : 鎴戞槸鍟嗗18
         * icon : http://120.27.23.105/images/icon.png
         * name : 鍟嗗18
         * productNums : 999
         * score : 5
         * sellerid : 18
         */

        private String description;
        private String icon;
        private String name;
        private int productNums;
        private double score;
        private int sellerid;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getProductNums() {
            return productNums;
        }

        public void setProductNums(int productNums) {
            this.productNums = productNums;
        }

        public double getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getSellerid() {
            return sellerid;
        }

        public void setSellerid(int sellerid) {
            this.sellerid = sellerid;
        }
    }

    public static class DataBean {
        /**
         * bargainPrice : 111.99
         * createtime : 2017-10-14T21:39:05
         * detailUrl : https://item.m.jd.com/product/4719303.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends
         * images : https://m.360buyimg.com/n0/jfs/t9004/210/1160833155/647627/ad6be059/59b4f4e1N9a2b1532.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7504/338/63721388/491286/f5957f53/598e95f1N7f2adb87.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7441/10/64242474/419246/adb30a7d/598e95fbNd989ba0a.jpg!q70.jpg
         * itemtype : 1
         * pid : 2
         * price : 299
         * pscid : 1
         * salenum : 999
         * sellerid : 18
         * subhead : 姣忎釜涓閮戒笉鑳界畝鍗曪紝鏃犺韬湪浣曞锛屼綘鎬婚渶瑕佷竴鍧楅ゼ璁╃敓娲绘洿鍦嗘弧锛屼含涓滄湀楗艰鐖辨洿鍦嗘弧浜笢鑷惀锛岄棯鐢甸厤閫侊紝鏇村鎯婂枩锛屽揩鐢ㄦ墜鎸囨埑涓€涓?
         * title : 鍖椾含绋婚鏉?绋婚鏉戜腑绉嬭妭鏈堥ゼ 鑰佸寳浜湀楗肩ぜ鐩?55g
         */

        private double bargainPrice;
        private String createtime;
        private String detailUrl;
        private String images;
        private int itemtype;
        private int pid;
        private double price;
        private int pscid;
        private int salenum;
        private double sellerid;
        private String subhead;
        private String title;

        public double getBargainPrice() {
            return bargainPrice;
        }

        public void setBargainPrice(double bargainPrice) {
            this.bargainPrice = bargainPrice;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getDetailUrl() {
            return detailUrl;
        }

        public void setDetailUrl(String detailUrl) {
            this.detailUrl = detailUrl;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public int getItemtype() {
            return itemtype;
        }

        public void setItemtype(int itemtype) {
            this.itemtype = itemtype;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getPscid() {
            return pscid;
        }

        public void setPscid(int pscid) {
            this.pscid = pscid;
        }

        public int getSalenum() {
            return salenum;
        }

        public void setSalenum(int salenum) {
            this.salenum = salenum;
        }

        public double getSellerid() {
            return sellerid;
        }

        public void setSellerid(int sellerid) {
            this.sellerid = sellerid;
        }

        public String getSubhead() {
            return subhead;
        }

        public void setSubhead(String subhead) {
            this.subhead = subhead;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

}
