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
            name: "hosts",
            alias: "/customer",
            component: HostList,
            children: [
                {
                    path: "/hosts/:host",
                    name: "host-details",
                    component: HostDetails,
                    props: true
                }
            ]
        }
    ]
});