import React from "react";
import { Description } from "@storybook/addon-docs/blocks";
import { DeepLinkRenderer } from "@storybook/native-components";
import { Emulator } from "../../utils/emulator";
import ButtonMD from "./button.stories.md";

function Template(args) {
  return (
    <div>
      <Emulator
        platform="android"
        storyParams={{ component: "button" }}
        {...args}
      />
      <Emulator
        platform="ios"
        storyParams={{ component: "button" }}
        {...args}
      />
    </div>
  );
}

const AndroidRenderer = ({ extraParams, component }) => {
  return (
    <DeepLinkRenderer
      apiKey="zv034bdme9je7c9d43chzmc2yg"
      platform="android"
      storyParams={{ component }}
      deepLinkBaseUrl="sb-native://deep.link"
      extraParams={extraParams}
      context="android"
    />
  );
};

const IosRenderer = ({ extraParams, component }) => {
  return (
    <DeepLinkRenderer
      apiKey="yc0e33432655wbjnnnemyghhxm"
      platform="ios"
      storyParams={{ component }}
      deepLinkBaseUrl="sb-native://deep.link"
      extraParams={extraParams}
      context="ios"
    />
  );
};

export const Button = (props) => {
  return (
    <div>
      <AndroidRenderer extraParams={props} component="button" />
      <IosRenderer extraParams={props} component="button" />
    </div>
  );
};

export default {
  title: "Material/Button",
  parameters: {
    docs: {
      page: function DocPages() {
        return <Description markdown={ButtonMD} />;
      },
    },
  },
};

export const Standard = Template.bind({});
Standard.parameters = {
  controls: { hideNoControlsWarning: true },
};

export const Controls = Template.bind({});
Controls.args = {
  label: "hai",
  variant: "contained",
  loading: false,
};
Controls.argTypes = {
  variant: {
    control: {
      type: "select",
      options: ["contained", "outlined", "text"],
    },
  },
  label: {
    control: {
      type: "text",
    },
  },
};
