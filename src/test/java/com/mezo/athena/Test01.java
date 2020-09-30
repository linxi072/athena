package com.mezo.athena;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.live.model.v20161101.*;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

/**
 * 域名管理
 */
public class Test01 {

    public final static String REGION_ID = "cn-hangzhou";
    public final static String ACCESS_KEY_ID = "LTAI4GDwu7g27Zs4LkVLw3Jr";
    public final static String ACCESS_SECRET = "kgRaORBUx6auIdlR7x3sTUDvAa0yvy";
    public final static String DOMAIN_NAME = "live.yourdomain.com";
    enum LiveDomainTypeEnum {
        LIVE_VIDEO("liveVideo"),
        LIVE_EDGE("liveEdge");
        String name;
        LiveDomainTypeEnum(String name) {
            this.name= name;
        }

    }
    //调用DescribeLiveDomainDetail获取指定直播域名配置的基本信息。
    @Test
    public void test01() {
        IAcsClient client = init();

        DescribeLiveDomainDetailRequest request = new DescribeLiveDomainDetailRequest();
        request.setRegionId(REGION_ID);
        request.setDomainName(DOMAIN_NAME);

        try {
            DescribeLiveDomainDetailResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }

    }
    //调用DescribeLiveCertificateDetail获取证书详细信息。
    @Test
    public void test02() {
        IAcsClient client = init();

        DescribeLiveCertificateDetailRequest request = new DescribeLiveCertificateDetailRequest();
        request.setRegionId(REGION_ID);
        request.setCertName(DOMAIN_NAME);

        try {
            DescribeLiveCertificateDetailResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }

    }
    //调用AddLiveDomain添加直播域名，一次只能提交一个域名。
    //限制条件：
    //创建直播域名之前，必须先开通live服务。
    //直播域名必须已备案完成。
    @Test
    public void test03() {
        IAcsClient client = init();

        AddLiveDomainRequest request = new AddLiveDomainRequest();
        request.setRegionId(REGION_ID);
        request.setLiveDomainType(LiveDomainTypeEnum.LIVE_VIDEO.name);
        request.setDomainName(DOMAIN_NAME);
        request.setRegion(REGION_ID);

        try {
            AddLiveDomainResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }

    }
    //添加主播放和子播放域名映射
    @Test
    public void test04() {
        IAcsClient client = init();

        AddLiveDomainMappingRequest request = new AddLiveDomainMappingRequest();
        request.setRegionId("cn-hangzhou");
        request.setPullDomain("aaa");

        try {
            AddLiveDomainMappingResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
    }
    @Test
    public void test10() {
        IAcsClient client = init();
        AddLivePullStreamInfoConfigRequest request = new AddLivePullStreamInfoConfigRequest();
        request.setRegionId(REGION_ID);
        try {
            AddLivePullStreamInfoConfigResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }

    }

    private IAcsClient init() {
        DefaultProfile profile = DefaultProfile.getProfile(REGION_ID, ACCESS_KEY_ID, ACCESS_SECRET);
        return new DefaultAcsClient(profile);
    }
}
