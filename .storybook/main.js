const path = require('path');
module.exports = {
    stories: ["../src/stories/**/*.stories.jsx"],
    addons: [
        "@storybook/addon-docs",
        "@storybook/addon-controls",
        "@storybook/native-addon/dist/register.js"
    ]
};