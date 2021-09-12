Setting environment variable
To actually tell storybook to interact with a local emulator, the `STORYBOOK_NATIVE_LOCAL_EMULATOR` environment variable must be set to a non-empty string.

Example:
```sh
export STORYBOOK_NATIVE_LOCAL_EMULATOR="true"
```

If you want to clear this value to go back to testing with your application with `appetize.io`, you can run:
```sh
export STORYBOOK_NATIVE_LOCAL_EMULATOR=
```

The [Storybook docs](https://storybook.js.org/docs/react/configure/environment-variables#using-env-files) discuss additional ways to declare this environment variable.

**IMPORTANT NOTE:** You should not have this environment variable set when you run the `build-storybook` command, as that will prevent your static storybook from working in production.