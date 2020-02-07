<template>
    <div class="list row">
        <div class="col-md-6">
            <h4>Host List</h4>
            <template>
                <div class="host-table" id="host-table">
                    <b-button variant="outline-primary" @click="refreshList">Refresh</b-button>
                    <AddHost></AddHost>
                    <b-table striped :items="hosts">
                    </b-table>
                </div>
            </template>
        </div>
        <div class="col-md-6">
            <router-view @refreshData="refreshList"></router-view>
        </div>
    </div>
</template>

<script>
    import http from "../http-common";
    import AddHost from "./AddHost";

    export default {
        name: "HostsList",
        components: {
            AddHost
        },
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