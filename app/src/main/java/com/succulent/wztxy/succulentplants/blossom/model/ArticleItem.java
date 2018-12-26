package com.succulent.wztxy.succulentplants.blossom.model;

public class ArticleItem {


    /**
     * title : 多肉盆栽如何养?一看就会了!
     * content_url : http://mp.weixin.qq.com/s?src=11×tamp=1545745088&ver=1317&signature=M1RS*IRSVGALyuY4l01jEqmOMOx97Stpkf7l9YS4rRi4DK8oWqbPCGGrolB5RljLlwzBfCdj23SAjiUIN8RwwVkxP1U5bN7So8gOBn9oGkxrcP0z9Fs5W7hCwVp6zKbD&new=1
     * datetime : 2018年12月10日
     * account_name : 多肉教授
     * cover_image : http://mmbiz.qpic.cn/mmbiz/rudlAwdDmicAlI1AyVadHQVqnRct0S6UFTfib5wODYRR11Lm1PjTOngHX3Im57D9yvbs9hUe254yKZWDfGicJicfKg/640?wx_fmt=jpeg
     * account_url : http://mp.weixin.qq.com/profile?src=3×tamp=1545745088&ver=1&signature=CkYJg3MeEj3M9cwsI-7uPatAdZUCRLdNYFklM2-gUxuu0nBoD4YKrQKA-McjiPd1a9egwTct9yPF*DeN5OFo2A==
     * digest :
     */

    private String title;
    private String content_url;
    private String datetime;
    private String account_name;
    private String cover_image;
    private String account_url;
    private String digest;
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent_url() {
        return content_url;
    }

    public void setContent_url(String content_url) {
        this.content_url = content_url;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getCover_image() {
        return cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
    }

    public String getAccount_url() {
        return account_url;
    }

    public void setAccount_url(String account_url) {
        this.account_url = account_url;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    @Override
    public String toString() {
        return "ArticleItem{" +
                "title='" + title + '\'' +
                ", content_url='" + content_url + '\'' +
                ", datetime='" + datetime + '\'' +
                ", account_name='" + account_name + '\'' +
                ", cover_image='" + cover_image + '\'' +
                ", account_url='" + account_url + '\'' +
                ", digest='" + digest + '\'' +
                '}';
    }
}
