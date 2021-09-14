import React from "react";
import { Description } from "@storybook/addon-docs/blocks";
import { Emulator } from "../../utils/emulator";
import ButtonMD from "./button.stories.md";

function Template(args) {
  return <Emulator storyParams={{ component: "button" }} {...args} />;
}

export default {
  title: "Material/Button",
  argTypes: {
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
  },
  parameters: {
    docs: {
      page: function DocPages() {
        return <Description markdown={ButtonMD} />;
      },
    },
  },
};

export const ButtonDefault = Template.bind({});
ButtonDefault.args = {
  label: "hai",
  variant: "contained",
};
