import React from "react";
import { ColorPalette, ColorItem } from "@storybook/addon-docs/blocks";
import { color } from "../../utils/styles";

export const ColorPaletteX = () => {
  return (
    <ColorPalette>
      <ColorItem
        title="theme.color.primary"
        subtitle="Primary Color"
        colors={{
          "Red 0": color.primaryColor.red_0,
          White: color.primaryColor.white,
        }}
      />
      <ColorItem
        title="theme.color.secondary"
        subtitle="Secondary Color"
        colors={{
          "Blue 0": color.blue.blue_0,
          "Yellow 0": color.yellow.yellow_0,
          "Green 0": color.green.green_0,
          "Gray 0": color.gray.gray_0,
        }}
      />
      <ColorItem
        title="theme.color.red"
        subtitle="Red Color"
        colors={{
          "Red 40": color.red.red_40,
          "Red 30": color.red.red_30,
          "Red 20": color.red.red_20,
          "Red 10": color.red.red_10,
          "Red 0": color.red.red_0,
          "Red -10": color.red.red_n10,
          "Red -20": color.red.red_n20,
          "Red -30": color.red.red_n30,
          "Red -40": color.red.red_n40,
        }}
      />

      <ColorItem
        title="theme.color.blue"
        subtitle="Blue Color"
        colors={{
          "Blue 20": color.blue.blue_20,
          "Blue 10": color.blue.blue_10,
          "Blue 0": color.blue.blue_0,
          "Blue -10": color.blue.blue_n10,
          "Blue -20": color.blue.blue_n20,
          "Blue -30": color.blue.blue_n30,
          "Blue -40": color.blue.blue_n40,
        }}
      />

      <ColorItem
        title="theme.color.yellow"
        subtitle="Yellow Color"
        colors={{
          "Yellow 20": color.yellow.yellow_20,
          "Yellow 10": color.yellow.yellow_10,
          "Yellow 0": color.yellow.yellow_0,
          "Yellow -10": color.yellow.yellow_n10,
          "Yellow -20": color.yellow.yellow_n20,
          "Yellow -30": color.yellow.yellow_n30,
          "Yellow -40": color.yellow.yellow_n40,
        }}
      />

      <ColorItem
        title="theme.color.green"
        subtitle="Green Color"
        colors={{
          "Green 20": color.green.green_20,
          "Green 10": color.green.green_10,
          "Green 0": color.green.green_0,
          "Green -10": color.green.green_n10,
          "Green -20": color.green.green_n20,
          "Green -30": color.green.green_n30,
          "Green -40": color.green.green_n40,
        }}
      />

      <ColorItem
        title="theme.color.gray"
        subtitle="Gray Color"
        colors={{
          "Gray 20": color.gray.gray_20,
          "Gray 10": color.gray.gray_10,
          "Gray 0": color.gray.gray_0,
          "Gray -10": color.gray.gray_n10,
          "Gray -20": color.gray.gray_n20,
          "Gray -30": color.gray.gray_n30,
          "Gray -40": color.gray.gray_n40,
        }}
      />

      <ColorItem
        title="theme.color.text"
        subtitle="Text Color"
        colors={{
          Midnight: color.text.midnight,
          Inactive: color.text.inactive,
          Placeholder: color.text.placeholder,
          White: color.text.white,
          Primary: color.text.primary,
          Error: color.text.error,
        }}
      />

      <ColorItem
        title="theme.color.background"
        subtitle="Background Color"
        colors={{
          White: color.background.white,
          "Field Inactive": color.background.field_inactive,
          Blackout: color.background.blackout,
        }}
      />

      <ColorItem
        title="theme.color.border"
        subtitle="Border Color"
        colors={{
          "Line / Border Field": color.border.field,
          "Line / Border Cards, Line & Divider": color.border.card,
        }}
      />
      {/* <ColorItem
        title="theme.color.positive"
        subtitle="Green"
        colors={{
          Apple: "rgba(102,191,60,1)",
          Apple80: "rgba(102,191,60,.8)",
          Apple60: "rgba(102,191,60,.6)",
          Apple30: "rgba(102,191,60,.3)",
        }}
      />
      <ColorItem
        title="gradient"
        subtitle="Grayscale"
        colors={{
          Gradient: "linear-gradient(to right,white,black)",
        }}
      /> */}
    </ColorPalette>
  );
};
