<template>
    <div v-if="this.host">
        <h4>Customer</h4>
        <div>
            <label>Host: </label> {{this.host.host}}
        </div>
        <div>
            <label>Schema: </label> {{this.host.schema}}
        </div>
        <div>
            <label>InProgress: </label> {{this.host.inProgress}}
        </div>

        <span v-if="this.host.inProgress"
              v-on:click="updateActive(false)"
              class="button is-small btn-primary">Inactive</span>
        <span v-else
              v-on:click="updateActive(true)"
              class="button is-small btn-primary">Active</span>

        <span class="button is-small btn-danger" v-on:click="deleteCustomer()">Delete</span>
    </div>
    <div v-else>
        <br/>
        <p>Please click on a Customer...</p>
    </div>
</template>

<script>
    import http from "../http-common";

    export default {
        name: "host",
        props: ["host"],
        methods: {
            /* eslint-disable no-console */
            updateActive(status) {
                var data = {
                    id: this.host.host,
                    name: this.host.schema,
                    age: this.host.inProgress,
                    active: status
                };

                http
                    .put("/customer/" + this.host.id, data)
                    .then(response => {
                        this.host.active = response.data.active;
                        console.log(response.data);
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            deleteCustomer() {
                http
                    .delete("/customer/" + this.host.host)
                    .then(response => {
                        console.log(response.data);
                        this.$emit("refreshData");
                        this.$router.push('/');
                    })
                    .catch(e => {
                        console.log(e);
                    });
            }
            /* eslint-enable no-console */
        }
    };
</script>