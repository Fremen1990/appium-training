FROM node:22-alpine3.20

ARG USERNAME=appium
ARG DIR=/home/${USERNAME}/tests

RUN adduser --gecos ${USERNAME} --disabled-password --shell /bin/sh --uid 1014 ${USERNAME} \
    && addgroup ${USERNAME} ${USERNAME}

RUN apk add --update npm

RUN mkdir ${DIR}
COPY js/test /${DIR}/test
COPY js/package.json /${DIR}/

WORKDIR ${DIR}

RUN npm install

USER ${USERNAME}

ENTRYPOINT ["npm", "test"]
