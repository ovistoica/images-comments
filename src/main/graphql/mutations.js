/* eslint-disable */
// this is an auto generated file. This will be overwritten

export const createDesign = /* GraphQL */ `
  mutation CreateDesign(
    $input: CreateDesignInput!
    $condition: ModelDesignConditionInput
  ) {
    createDesign(input: $input, condition: $condition) {
      id
      name
      context
      shots {
        items {
          id
          url
          designID
          createdAt
          updatedAt
          _version
          _deleted
          _lastChangedAt
          owner
        }
        nextToken
        startedAt
      }
      createdAt
      updatedAt
      _version
      _deleted
      _lastChangedAt
      owner
    }
  }
`;
export const updateDesign = /* GraphQL */ `
  mutation UpdateDesign(
    $input: UpdateDesignInput!
    $condition: ModelDesignConditionInput
  ) {
    updateDesign(input: $input, condition: $condition) {
      id
      name
      context
      shots {
        items {
          id
          url
          designID
          createdAt
          updatedAt
          _version
          _deleted
          _lastChangedAt
          owner
        }
        nextToken
        startedAt
      }
      createdAt
      updatedAt
      _version
      _deleted
      _lastChangedAt
      owner
    }
  }
`;
export const deleteDesign = /* GraphQL */ `
  mutation DeleteDesign(
    $input: DeleteDesignInput!
    $condition: ModelDesignConditionInput
  ) {
    deleteDesign(input: $input, condition: $condition) {
      id
      name
      context
      shots {
        items {
          id
          url
          designID
          createdAt
          updatedAt
          _version
          _deleted
          _lastChangedAt
          owner
        }
        nextToken
        startedAt
      }
      createdAt
      updatedAt
      _version
      _deleted
      _lastChangedAt
      owner
    }
  }
`;
export const createShot = /* GraphQL */ `
  mutation CreateShot(
    $input: CreateShotInput!
    $condition: ModelShotConditionInput
  ) {
    createShot(input: $input, condition: $condition) {
      id
      url
      designID
      design {
        id
        name
        context
        shots {
          nextToken
          startedAt
        }
        createdAt
        updatedAt
        _version
        _deleted
        _lastChangedAt
        owner
      }
      createdAt
      updatedAt
      _version
      _deleted
      _lastChangedAt
      owner
    }
  }
`;
export const updateShot = /* GraphQL */ `
  mutation UpdateShot(
    $input: UpdateShotInput!
    $condition: ModelShotConditionInput
  ) {
    updateShot(input: $input, condition: $condition) {
      id
      url
      designID
      design {
        id
        name
        context
        shots {
          nextToken
          startedAt
        }
        createdAt
        updatedAt
        _version
        _deleted
        _lastChangedAt
        owner
      }
      createdAt
      updatedAt
      _version
      _deleted
      _lastChangedAt
      owner
    }
  }
`;
export const deleteShot = /* GraphQL */ `
  mutation DeleteShot(
    $input: DeleteShotInput!
    $condition: ModelShotConditionInput
  ) {
    deleteShot(input: $input, condition: $condition) {
      id
      url
      designID
      design {
        id
        name
        context
        shots {
          nextToken
          startedAt
        }
        createdAt
        updatedAt
        _version
        _deleted
        _lastChangedAt
        owner
      }
      createdAt
      updatedAt
      _version
      _deleted
      _lastChangedAt
      owner
    }
  }
`;
