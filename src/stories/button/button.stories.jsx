import React from "react";
import { Description } from "@storybook/addon-docs/blocks";
import { Emulator } from "../../utils/emulator";
import ButtonMD from "./button.stories.md";

function Template(args) {
  return <Emulator storyParams={{ component: "button" }} {...args} />;
}

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
