<template>
    <div>
        <el-row :gutter="20">
            <el-col :span="8">
                <el-card shadow="hover" class="mgb20" style="height:252px;">
                    <div class="user-info">
                        <img src="../../assets/img/img.jpg" class="user-avator" alt />
                        <div class="user-info-cont">
                            <div class="user-info-name">{{nickname}}</div>
                            <div>{{role}}</div>
                        </div>
                    </div>
                    <div class="user-info-list">
                        上次登录时间：<span>{{lastLoginTime}}</span>
                    </div>
                </el-card>
            </el-col>
            <!--<el-col :span="16">-->
                <!--<el-row :gutter="20" class="mgb20" v-if="userType === '1'">-->
                    <!--<el-col :span="8">-->
                        <!--<el-card shadow="hover" :body-style="{padding: '0px'}">-->
                            <!--<div class="grid-content grid-con-1">-->
                                <!--<i class="el-icon-lx-people grid-con-icon"></i>-->
                                <!--<div class="grid-cont-right">-->
                                    <!--<div class="grid-num">1234</div>-->
                                    <!--<div>用户访问量</div>-->
                                <!--</div>-->
                            <!--</div>-->
                        <!--</el-card>-->
                    <!--</el-col>-->
                <!--</el-row>-->
            <!--</el-col>-->
        </el-row>
    </div>
</template>

<script>
import Schart from 'vue-schart';
import bus from '../common/bus';
export default {
    name: 'dashboard',
    data() {
        return {
            nickname: '',
            userType: '',
            lastLoginTime: ''
        };
    },
    components: {
        Schart
    },
    computed: {
        role() {
            return this.userType === '1' ? '系统管理员' : '普通用户';
        }
    },
    mounted() {
        let userInfoStr = localStorage.getItem('ms_username')
        let userInfo = JSON.parse(userInfoStr)
        this.userType = userInfo.userType
        this.nickname = userInfo.nickname
        this.lastLoginTime = userInfo.lastLoginTimeText
    },
    methods: {
    }
};
</script>


<style scoped>
.el-row {
    margin-bottom: 20px;
}

.grid-content {
    display: flex;
    align-items: center;
    height: 100px;
}

.grid-cont-right {
    flex: 1;
    text-align: center;
    font-size: 14px;
    color: #999;
}

.grid-num {
    font-size: 30px;
    font-weight: bold;
}

.grid-con-icon {
    font-size: 50px;
    width: 100px;
    height: 100px;
    text-align: center;
    line-height: 100px;
    color: #fff;
}

.grid-con-1 .grid-con-icon {
    background: rgb(45, 140, 240);
}

.grid-con-1 .grid-num {
    color: rgb(45, 140, 240);
}

.grid-con-2 .grid-con-icon {
    background: rgb(100, 213, 114);
}

.grid-con-2 .grid-num {
    color: rgb(45, 140, 240);
}

.grid-con-3 .grid-con-icon {
    background: rgb(242, 94, 67);
}

.grid-con-3 .grid-num {
    color: rgb(242, 94, 67);
}

.user-info {
    display: flex;
    align-items: center;
    padding-bottom: 20px;
    border-bottom: 2px solid #ccc;
    margin-bottom: 20px;
}

.user-avator {
    width: 120px;
    height: 120px;
    border-radius: 50%;
}

.user-info-cont {
    padding-left: 50px;
    flex: 1;
    font-size: 14px;
    color: #999;
}

.user-info-cont div:first-child {
    font-size: 30px;
    color: #222;
}

.user-info-list {
    font-size: 14px;
    color: #999;
    line-height: 25px;
}

.user-info-list span {
    margin-left: 20px;
}

.mgb20 {
    margin-bottom: 20px;
}

.todo-item {
    font-size: 14px;
}

.todo-item-del {
    text-decoration: line-through;
    color: #999;
}

.schart {
    width: 100%;
    height: 300px;
}
</style>
