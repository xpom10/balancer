<template>
    <div id="app">
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