<template>
    <div id="app" class="container-fluid">
        <div class="site-info">
            <h1>Balancer</h1>
        </div>
        <nav>
            <b-button variant="outline-primary" to="/">Hosts</b-button>
        </nav>
        <br/>
        <router-view/>
    </div>
</template>

<script>

    export default {
        name: "app"
    };
</script>

<style>
    .site-info {
        color: blue;
        margin-bottom: 20px;
    }
</style>