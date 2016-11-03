package com.jandzy.news.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jrazy on 2016/11/3.
 */
public class JokesModel implements Serializable{

    /**
     * error_code : 0
     * reason : Success
     * result : {"data":[{"content":"&nbsp; &nbsp; 表弟上学时报考了护理专业，一进班就乐傻了，32个女生1个男，简直就是万花之间一只小蜜蜂啊。可日子长了，天天泡在脂粉堆就觉得兴趣淡了，几个女生追求他都没珍惜。直到进入社会，昨天独自过了第32个小光棍节时，他才知道错过了他人生的巅峰..","hashId":"29aba9c62d0502911ee390fb570f8b61","unixtime":1478139233,"updatetime":"2016-11-03 10:13:53"},{"content":"&nbsp; &nbsp; 双十一快到了，在某宝给老婆选几身衣服，看评论时候看到了我认为史上最让卖家含冤的一个评论:差评，为什么我老婆穿了你家衣服还是那么丑？","hashId":"cc811065b7c1257cd5fc2d45bcf66492","unixtime":1478139233,"updatetime":"2016-11-03 10:13:53"},{"content":"男嘉宾问留灯的女生：\u201c你平时喜欢做什么？\u201d　　女生开心的说：\u201c我喜欢到处吃好吃的。\u201d　　男嘉宾又问心动女生，心动女生想了想：\u201c我喜欢看书，做家务。\u201d　　男嘉宾最终选择了留灯女生。　　主持人问其原因，男嘉宾笑着说：\u201c吃货比较单纯。\u201d","hashId":"981f3642f9572e0727d0f75592a4a671","unixtime":1478138632,"updatetime":"2016-11-03 10:03:52"},{"content":"屌丝：\u201c做我女朋友好么？\u201d　　白富美：\u201c你死了这条心吧，就算全世界的男人都死光了我也不会看上你。\u201d　　屌丝：\u201c要是全世界的男人都死光了我还看得上你？\u201d","hashId":"2f14d27c53f5bed1ad7f14e2486f5adf","unixtime":1478138632,"updatetime":"2016-11-03 10:03:52"},{"content":"火锅城为了招揽生意，　　在广告牌上写了这样一句话：\u201c自助火锅，每位30元，身高1米以下的儿童免费。\u201d　　幼儿园的阿姨看后无比激动，她怀揣30元钱，领着班上的50名小朋友来到了火锅城。","hashId":"88a947dcade09ff7d19679bcf900e5ff","unixtime":1478138632,"updatetime":"2016-11-03 10:03:52"},{"content":"小时候上体育课，　　女生和体育老师说：\u201c今天我不方便跑。\u201d　　1000米就可以不用跑了。 　　然后我也跑过去，和老师说了句：\u201c老师，今天我也不方便跑。\u201d　　然后不但跑完 了那该死的1000米，又加跑了2000米。","hashId":"2150743e274c6b36478c1deaa018cd5c","unixtime":1478138632,"updatetime":"2016-11-03 10:03:52"},{"content":"我真希望哪天遇见个什么大仙在我头上一点，　　手持照妖镜对我吼上一句\u201c妖孽看你往哪里跑还不速速还原\u201d。　　然后我就迅速的瘦下去了。","hashId":"cf6b97ee56ff6b09e82eeeaaa4c3f6d2","unixtime":1478138632,"updatetime":"2016-11-03 10:03:52"},{"content":"话说班里有个屌丝男，有一天他爸爸换手机号了给他打电话，他问谁啊，　　他爸说你爹，他说别闹，你到底谁啊，他爸说我是你爹，　　结果这货以为有人玩他就开始骂，后来他爹也蒙了，　　跟他说小b崽子，xxx[他名字]，你他妈听不出来你爹的声了？　　你他妈骂谁呢？这月钱给你断了，你他妈管同学借去吧！　　然后一怒之下挂了电话，那屌丝男在风中凌乱了。","hashId":"231974f998ae65b002784324f763eedc","unixtime":1478138632,"updatetime":"2016-11-03 10:03:52"}]}
     */

    private int error_code;
    private String reason;
    private ResultEntity result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultEntity getResult() {
        return result;
    }

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public static class ResultEntity {
        /**
         * content : &nbsp; &nbsp; 表弟上学时报考了护理专业，一进班就乐傻了，32个女生1个男，简直就是万花之间一只小蜜蜂啊。可日子长了，天天泡在脂粉堆就觉得兴趣淡了，几个女生追求他都没珍惜。直到进入社会，昨天独自过了第32个小光棍节时，他才知道错过了他人生的巅峰..
         * hashId : 29aba9c62d0502911ee390fb570f8b61
         * unixtime : 1478139233
         * updatetime : 2016-11-03 10:13:53
         */

        private List<DataEntity> data;

        public List<DataEntity> getData() {
            return data;
        }

        public void setData(List<DataEntity> data) {
            this.data = data;
        }

        public static class DataEntity {
            private String content;
            private String hashId;
            private int unixtime;
            private String updatetime;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getHashId() {
                return hashId;
            }

            public void setHashId(String hashId) {
                this.hashId = hashId;
            }

            public int getUnixtime() {
                return unixtime;
            }

            public void setUnixtime(int unixtime) {
                this.unixtime = unixtime;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }
        }
    }
}
