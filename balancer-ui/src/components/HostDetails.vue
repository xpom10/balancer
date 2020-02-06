<template>
    <div v-if="this.hostDetails">
        <h4>Host details</h4>
        <div>
            <label>Host: </label> {{this.hostDetails.host}}
        </div>
        <div>
            <label>Schema: </label> {{this.hostDetails.schema}}
        </div>
        <div>
            <label>InProgress: </label> {{this.hostDetails.inProgress}}
        </div>

    </div>
    <div v-else>
        <br/>
        <p>Please click on a Host...</p>
    </div>
</template>

<script>
    export default {
        name: "HostDetails",
        props: ["hostDetails"],
    };
</script>