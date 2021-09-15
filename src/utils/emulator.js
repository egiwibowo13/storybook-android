import React from "react";
import { EmulatorRenderer } from "@storybook/native-components";

export const Emulator = ({ storyParams, platform = "android", ...props }) => {
  return (
    <EmulatorRenderer
      apiKey="zv034bdme9je7c9d43chzmc2yg"
      platform={platform}
      storyParams={storyParams}
      deepLinkBaseUrl={"sb-native://deep.link"}
      extraParams={props}
    />
  );
};
