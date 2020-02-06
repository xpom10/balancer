import Vue from "vue";
import Router from "vue-router";
import HostList from "./components/HostList.vue";
import HostDetails from "./components/HostDetails.vue"

Vue.use(Router);

export default new Router({
    mode: "history",
    routes: [
        {
            path: "/",
            name: "HostList",
            alias: "/hosts",
            component: HostList,
            children: [
                {
                    path: "/hosts/:id",
                    name: "HostDetails",
                    component: HostDetails,
                    props: true
                }
            ]
        }
    ]
});