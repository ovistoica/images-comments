const path = require('path');
const webpack = require('webpack')

module.exports = {
    mode: "production",
    entry: './target/index.js',
    output: {
        path: path.resolve(__dirname, 'public/js/libs'),
        filename: 'bundle.js',
        clean: true,
    },
    plugins: [
        // fix "process is not defined" error:
        // (do "npm install process" before running the build)
        new webpack.ProvidePlugin({
            process: 'process/browser',
        }),
    ],
    module: {
        rules: [
            {
                // docs: https://webpack.js.org/configuration/module/#resolvefullyspecified
                test: /\.m?js/,
                resolve: {
                    fullySpecified: false,
                }
            }
        ]
    },
};
