const path = require('path');
module.exports = {
    stories: ["../src/stories/**/*.stories.jsx", "../src/stories/**/*.stories.mdx", "../src/stories/*.stories.mdx"],
    addons: [
        {
            name: '@storybook/addon-docs',
            options: {
                configureJSX: true,
                babelOptions: {},
                sourceLoaderOptions: null,
            },
        },
        "@storybook/addon-controls",
        "@storybook/native-addon/dist/register.js"
    ],
    webpackFinal: async (config, { configType }) => {
        // `configType` has a value of 'DEVELOPMENT' or 'PRODUCTION'
        // You can change the configuration based on that.
        // 'PRODUCTION' is used when building the static version of storybook.
    
        // Make whatever fine-grained changes you need
        config.module.rules.push(
            {
                test: /\.xml$/i,
                use: 'raw-loader',
              },
        );
    
        // Return the altered config
        return config;
      },
};