
    import React from 'react';
    import { EmulatorRenderer } from '@storybook/native-components';

    export const Emulator = (props) => {
        return <EmulatorRenderer
            apiKey={`zv034bdme9je7c9d43chzmc2yg`}
            platform={`android`}
            storyParams={`[object Object]`}
            deepLinkBaseUrl={`sb-native://deep.link`}
            extraParams={props}
        />;
    };
    