$(function() {
    var Sarr = ["北京", "天津", "上海", "重庆", "河北", "山西", "内蒙古", "辽宁", "吉林", "黑龙江", "江苏", "浙江", "安徽", "福建", "江西", "山东", "河南", "湖北", "湖南", "广东", "广西", "海南", "四川", "贵州", "云南", "西藏", "陕西", "甘肃", "青海", "宁夏", "新疆", "香港", "澳门", "台湾", "广东", "湖北", "湖南"]
    $(".region").on("focus", function() {
        var region_index = 0,
            region_list = $(".region_list"),
            that_input = this,
            text = "",
            checkText = "",
            demo = "";
        for (var i = 0; i < Sarr.length; i++) {
            var newDom = '<li>' + '<a href="javascript:;">' + Sarr[i] + '</a>' + '</li>';
            demo += newDom;
        }
        $(region_list[region_index]).find("ul").html(demo);
        assembly.$region(region_list[region_index]);
        setTimeout(function() {
            $(region_list[region_index]).css("position", "absolute")
            update(function() {
                update();
            });
        }, 200)

        function update(success) {
            var list_btn = region_list.find("a");
            for (var i = 0; i < list_btn.length; i++) {
                var self = list_btn[i];
                self.fun = success;
                self.onclick = function() {
                    checkText = this.innerHTML;
                    //alert(checkText)
                    Hbtn(function() {
                        update();
                    }, this);
                };
            }
        }

        function Hbtn(success, target) {
            region_index++;
            var demo2 = "",
                Harr;

            switch (checkText) {
                case "北京":
                    Harr = ["西城", "东城", "崇文", "宣武", "朝阳", "海淀", "丰台", "石景山", "门头沟", "房山", "通州", "顺义", "大兴", "昌平", "平谷", "怀柔", "密云", "延庆"]
                    break;
                case "天津":
                    Harr = ["青羊", "河东", "河西", "南开", "河北", "红桥", "塘沽", "汉沽", "大港", "东丽", "西青", "北辰", "津南", "武清", "宝坻", "静海", "宁河", "蓟县", "开发区"]
                    break;
                case "河北":
                    Harr = ["石家庄", "秦皇岛", "廊坊", "保定", "邯郸", "唐山", "邢台", "衡水", "张家口", "承德", "沧州", "衡水"]
                    break;
                case "山西":
                    Harr = ["太原", "大同", "长治", "晋中", "阳泉", "朔州", "运城", "临汾"]
                    break;
                case "内蒙古":
                    Harr = ["呼和浩特", "赤峰", "通辽", "锡林郭勒", "兴安"]
                    break;
                case "辽宁":
                    Harr = ["大连", "沈阳", "鞍山", "抚顺", "营口", "锦州", "丹东", "朝阳", "辽阳", "阜新", "铁岭", "盘锦", "本溪", "葫芦岛"]
                    break;
                case "吉林":
                    Harr = ["长春", "吉林", "四平", "辽源", "通化", "延吉", "白城", "辽源", "松原", "临江", "珲春"]
                    break;
                case "黑龙江":
                    Harr = ["哈尔滨", "齐齐哈尔", "大庆", "牡丹江", "鹤岗", "佳木斯", "绥化"]
                    break;
                case "上海":
                    Harr = ["浦东", "杨浦", "徐汇", "静安", "卢湾", "黄浦", "普陀", "闸北", "虹口", "长宁", "宝山", "闵行", "嘉定", "金山", "松江", "青浦", "崇明", "奉贤", "南汇"]
                    break;
                case "江苏":
                    Harr = ["南京", "苏州", "无锡", "常州", "扬州", "徐州", "南通", "镇江", "泰州", "淮安", "连云港", "宿迁", "盐城", "淮阴", "沐阳", "张家港"]
                    break;
                case "浙江":
                    Harr = ["杭州", "金华", "宁波", "温州", "嘉兴", "绍兴", "丽水", "湖州", "台州", "舟山", "衢州"]
                    break;
                case "安徽":
                    Harr = ["合肥", "马鞍山", "蚌埠", "黄山", "芜湖", "淮南", "铜陵", "阜阳", "宣城", "安庆"]
                    break;
                case "福建":
                    Harr = ["福州", "厦门", "泉州", "漳州", "南平", "龙岩", "莆田", "三明", "宁德"]
                    break;
                case "江西":
                    Harr = ["南昌", "景德镇", "上饶", "萍乡", "九江", "吉安", "宜春", "鹰潭", "新余", "赣州"]
                    break;
                case "山东":
                    Harr = ["青岛", "济南", "淄博", "烟台", "泰安", "临沂", "日照", "德州", "威海", "东营", "荷泽", "济宁", "潍坊", "枣庄", "聊城"]
                    break;
                case "河南":
                    Harr = ["郑州", "洛阳", "开封", "平顶山", "濮阳", "安阳", "许昌", "南阳", "信阳", "周口", "新乡", "焦作", "三门峡", "商丘"]
                    break;
                case "湖北":
                    Harr = ["武汉", "襄樊", "孝感", "十堰", "荆州", "黄石", "宜昌", "黄冈", "恩施", "鄂州", "江汉", "随枣", "荆沙", "咸宁"]
                    break;
                case "湖南":
                    Harr = ["长沙", "湘潭", "岳阳", "株洲", "怀化", "永州", "益阳", "张家界", "常德", "衡阳", "湘西", "邵阳", "娄底", "郴州"]
                    break;
                case "广东":
                    Harr = ["广州", "深圳", "东莞", "佛山", "珠海", "汕头", "韶关", "江门", "梅州", "揭阳", "中山", "河源", "惠州", "茂名", "湛江", "阳江", "潮州", "云浮", "汕尾", "潮阳", "肇庆", "顺德", "清远"]
                    break;
                case "广西":
                    Harr = ["南宁", "桂林", "柳州", "梧州", "来宾", "贵港", "玉林", "贺州"]
                    break;
                case "海南":
                    Harr = ["海口", "三亚"]
                    break;
                case "重庆":
                    Harr = ["渝中", "大渡口", "江北", "沙坪坝", "九龙坡", "南岸", "北碚", "万盛", "双桥", "渝北", "巴南", "万州", "涪陵", "黔江", "长寿"]
                    break;
                case "四川":
                    Harr = ["成都", "达州", "南充", "乐山", "绵阳", "德阳", "内江", "遂宁", "宜宾", "巴中", "自贡", "康定", "攀枝花"]
                    break;
                case "贵州":
                    Harr = ["贵阳", "遵义", "安顺", "黔西南", "都匀"]
                    break;
                case "云南":
                    Harr = ["昆明", "丽江", "昭通", "玉溪", "临沧", "文山", "红河", "楚雄", "大理"]
                    break;
                case "西藏":
                    Harr = ["拉萨", "林芝", "日喀则", "昌都"]
                    break;
                case "陕西":
                    Harr = ["西安", "咸阳", "延安", "汉中", "榆林", "商南", "略阳", "宜君", "麟游", "白河"]
                    break;
                case "甘肃":
                    Harr = ["兰州", "金昌", "天水", "武威", "张掖", "平凉", "酒泉"]
                    break;
                case "台湾":
                    Harr = ["台北", "新北", "桃园", "台中", "台南", "高雄"]
                    break;
                case "青海":
                    Harr = ["黄南", "海南", "西宁", "海东", "海西", "海北", "果洛", "玉树"]
                    break;
                case "宁夏":
                    Harr = ["银川", "吴忠"]
                    break;
                case "新疆":
                    Harr = ["乌鲁木齐", "哈密", "喀什", "巴音郭楞", "昌吉", "伊犁", "阿勒泰", "克拉玛依", "博尔塔拉"]
                    break;
                case "香港":
                    Harr = ["中西区", "湾仔区", "东区", "南区", "九龙-油尖旺区", "九龙-深水埗区", "九龙-九龙城区", "九龙-黄大仙区", "九龙-观塘区", "新界-北区", "新界-大埔区", "新界-沙田区", "新界-西贡区", "新界-荃湾区", "新界-屯门区", "新界-元朗区", "新界-葵青区", "新界-离岛区"]
                    break;
                case "澳门":
                    Harr = ["花地玛堂区", "圣安多尼堂区", "大堂区", "望德堂区", "风顺堂区", "嘉模堂区", "圣方济各堂区", "路氹城"]
                    break;
                default:
                    Harr = []
            }

            for (var i = 0; i < Harr.length; i++) {
                var newDom = '<li>' + '<a href="javascript:;">' + Harr[i] + '</a>' + '</li>';
                demo2 += newDom;
            }
            $(region_list[region_index]).find("ul").html(demo2);
            list_btn = region_list.find("a");
            if (region_index === region_list.length) {
                text += target.innerHTML;
                $(region_list[region_index - 1]).css({
                    "transform": "translateX(0)",
                    "position": "fixed"
                })
                region_index = 0;
                that_input.value = text;
            } else {
                assembly.$region(region_list[region_index]);
                setTimeout(function() {
                    $(region_list[region_index]).css("position", "absolute");
                    $(region_list[region_index - 1]).css({
                        "transform": "translateX(0)",
                        "position": "fixed"
                    })
                }, 200)
                text += target.innerHTML;
            }
            success();
        }
    })
})