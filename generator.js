const fs = require("fs").promises;

const toProperCase = function (str) {
  return str.replace(/\w\S*/g, function (txt) {
    return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();
  });
};

const template = ({ name, doc }) => {
  return `
import React from 'react';
import { Description } from '@storybook/addon-docs/blocks';
import { Emulator } from './emulator';

export const ${toProperCase(name)} = (props) => {
    return <Emulator {...props} />;
};

${toProperCase(name)}.parameters = {
    docs: {
        page: () => <Description markdown={${doc}} /> }}
    `;
};

const templateEmulator = ({
  apiKey,
  platform,
  storyParams,
  deepLinkBaseUrl,
}) => {
  return `
    import React from 'react';
    import { EmulatorRenderer } from '@storybook/native-components';

    export const Emulator = (props) => {
        return <EmulatorRenderer
            apiKey={\`${apiKey}\`}
            platform={\`${platform}\`}
            storyParams={\`${storyParams}\`}
            deepLinkBaseUrl={\`${deepLinkBaseUrl}\`}
            extraParams={props}
        />;
    };
    `;
};

async function getDocByFilePath() {
  try {
    const data = await fs.readFile("./button.md", "utf-8");
    return data;
  } catch (error) {
    return "";
  }
}

async function generateTemplateEmulator({
  apiKey,
  platform,
  storyParams,
  deepLinkBaseUrl,
}) {
  try {
    const contents = templateEmulator({
      apiKey,
      platform,
      storyParams,
      deepLinkBaseUrl,
    });
    await fs.writeFile("emulator.jsx", contents);
    console.log(`Saved template!`);
  } catch (error) {
    console.error(`Autsch! Failed to store template: ${error.message}.`);
  }
}

async function generator() {
  await generateTemplateEmulator({
    apiKey: "zv034bdme9je7c9d43chzmc2yg",
    platform: "android",
    storyParams: { a: "a" },
    deepLinkBaseUrl: "sb-native://deep.link",
  });
  const a = await getDocByFilePath();
  const contents = template({
    name: "button",
    doc: `\`${a.replace(/`/g, "\\`")}\``,
  });
  try {
    await fs.writeFile("contents.jsx", contents);
    console.log(`Saved template!`);
  } catch (error) {
    console.error(`Autsch! Failed to store template: ${error.message}.`);
  }
}

generator();
