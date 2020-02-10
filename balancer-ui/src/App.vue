<template>
    <div id="app" class="container-fluid">
        <div class="site-info">
            <h1>Balancer</h1>
        </div>
        <HostList/>
    </div>
</template>

<script>
    import HostList from './components/HostList'

    export default {
        name: "app",
        components: {
            HostList
        }
    };
</script>

<style>
    .site-info {
        color: blue;
        margin-bottom: 20px;
    }
</style>