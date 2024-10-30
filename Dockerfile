FROM node:22-alpine3.20

ARG USERNAME=appium
ARG DIR=/home/${USERNAME}/tests

RUN adduser --gecos ${USERNAME} --disabled-password --shell /bin/sh --uid 1014 ${USERNAME} \
    && addgroup ${USERNAME} ${USERNAME}

RUN apk add --update npm

RUN mkdir -p ${DIR}
COPY js/test /${DIR}/test
COPY js/package.json /${DIR}/

WORKDIR ${DIR}

#RUN npm cache clean --force && npm install --verbose

RUN yarn


USER ${USERNAME}

#ENTRYPOINT sleep 3600

ENTRYPOINT ["npm", "test"]

#registry=https://registry.npmjs.org
#strict-ssl=false