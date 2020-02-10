<template>
    <div class="list row">
        <div class="position-relative">
            <template>
                <div>
                    <div class="d-inline p-2" id="host-table">
                        <b-button variant="outline-primary" @click="refreshList">Refresh</b-button>
                        <AddHost class="d-inline p-2" @refreshData="refreshList"/>
                    </div>
                    <div id="host-table-id" class="table-responsive">
                    <b-table class="table" show-empty bordered striped hover :items="hosts" :fields="fields">
                    </b-table>
                    </div>
                </div>
            </template>
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
                fields: [
                    {
                        key: 'host',
                        sortable: true
                    },
                    {
                        key: 'schema',
                        sortable: true
                    },
                    {
                        key: 'inProgress',
                        sortable: true
                    }
                ],
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