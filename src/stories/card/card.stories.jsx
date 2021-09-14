import React from "react";
import { Description } from "@storybook/addon-docs/blocks";
import { Emulator } from "../../utils/emulator";
import CardMD from "./card.stories.md";

function Template(args) {
  return <Emulator storyParams={{ component: "card" }} {...args} />;
}

export const CardDefault = Template.bind({});
CardDefault.args = {
  label: "hai",
  variant: "contained",
};

CardDefault.parameters = {
  docs: {
    page: () => <Description markdown={CardMD} />,
  },
};

export default {
  title: "Material/Card",
};
