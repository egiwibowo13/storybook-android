import React from "react";
import { Description } from "@storybook/addon-docs/blocks";
import { Emulator } from "../../utils/emulator";

export function TypographyTemplate(args) {
  return <Emulator storyParams={{ component: "button" }} {...args} />;
}

export const Dess = () => {
  return <Description markdown="hai" />;
};
