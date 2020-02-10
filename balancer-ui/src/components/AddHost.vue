<template>
    <b-dropdown id="dropdown-form" text="Add" ref="dropdown">
        <b-dropdown-form @submit="addHost" @reset="onReset">

            <b-form-group label="Host" label-for="dropdown-form-host" @submit.stop.prevent size="lg">
                <b-form-input
                        v-model="host.host"
                        id="dropdown-form-host"
                        size="sm"
                ></b-form-input>
            </b-form-group>

            <b-form-group label="Schema" label-for="dropdown-form-schema">
                <b-form-input
                        v-model="host.schema"
                        id="dropdown-form-schema"
                        size="sm"
                ></b-form-input>
            </b-form-group>
            <b-button-group>
                <b-button type="submit" variant="primary" size="sm" class="mb-sm-0">Add</b-button>
                <b-button type="reset" variant="primary" size="sm" class="mb-sm-0">Cancel</b-button>
            </b-button-group>
        </b-dropdown-form>
    </b-dropdown>
</template>
<script>
    import http from '../http-common'

    export default {
        name: "AddHost",
        data() {
            return {
                host: {}
            }
        },
        methods: {
            addHost(e) {
                e.preventDefault();

                this.$refs.dropdown.hide(true);
                http.post("/hosts", this.host)
                    .then(response =>{
                        this.host = response.data;
                        console.log(this.host);
                        console.log(response.data)
                    })
                    .catch(e => {
                    console.log(e);
                });
                this.$emit("addHost", this.host);
                this.host = {};
            },
            onReset(e) {
                e.preventDefault();
                this.host = {};
                this.$refs.dropdown.hide(true);
            }
        }

    }
</script>

<style scoped>

</style>