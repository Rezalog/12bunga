<template>

    <v-data-table
        :headers="headers"
        :items="status"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'StatusView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "status", value: "status" },
            ],
            status : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/statuses'))

            temp.data._embedded.statuses.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.status = temp.data._embedded.statuses;
        },
        methods: {
        }
    }
</script>

