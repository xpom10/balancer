<template>
    <div class="list row">
        <div class="col-md-6">
            <h4>Host List</h4>
            <ul>
                <li v-for="(host, index) in hosts" :key="index" :host="host">
                    <router-link :to="{
                            name: 'HostDetails',
                            params: { id: host.host, hostDetails: host }
                        }">
                        {{host.host}}
                    </router-link>
                </li>
            </ul>
        </div>
        <div class="col-md-6">
            <router-view @refreshData="refreshList"></router-view>
        </div>
    </div>
</template>

<script>
    import http from "../http-common";

    export default {
        name: "HostsList",
        data() {
            return {
                hosts: []
            };
        },
        methods: {
            /* eslint-disable no-console */
            retrieveHosts() {
                http
                    .get("/hosts")
                    .then(response => {
                        this.hosts = response.data; // JSON are parsed automatically.
                        console.log(response.data);
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            refreshList() {
                this.retrieveHosts();
            }
            /* eslint-enable no-console */
        },
        mounted() {
            this.retrieveHosts();
        }
    };
</script>

<style>
    .list {
        text-align: left;
        max-width: 450px;
        margin: auto;
    }
</style>