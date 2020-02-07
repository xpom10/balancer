<template>
    <div>
        <b-dropdown id="dropdown-form" text="Add" ref="dropdown" class="m-5">
            <b-dropdown-form @submit="addHost" @reset="onReset">
                <b-form-group label="Host" label-for="dropdown-form-host" @submit.stop.prevent>
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

                <b-button type="submit" variant="primary" size="sm">Add</b-button>
                <b-button type="reset" variant="primary" size="sm" class="mb-sm-0">Cancel</b-button>
            </b-dropdown-form>
        </b-dropdown>
    </div>
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
                http.post("/hosts", this.host).catch(e => {
                    console.log(e);
                });
                this.$emit("refreshData");
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