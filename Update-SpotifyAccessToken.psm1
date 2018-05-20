function Update-SpotifyAccessToken {

    [CmdletBinding()]
    param (
        [Parameter(Mandatory)]
        # The Spotify API Refresh Access token.
        # This is provided as part of the API Authorisation process.
        [String]$RefreshToken,

        [Parameter(Mandatory)]
        # The Spotify API Client Id.
        # Provided from the Developer Pages.
        [String]$ClientId,

        [Parameter(Mandatory)]
        # The Spotify API Client Secret.
        # Provided from the Developer Pages.
        [String]$ClientSecret,

        [Parameter(Mandatory = $false)]
        # The Spotify API Token Uri.
        [String]$ApiUri = "https://accounts.spotify.com/api/token"
    )

    # Build up the header parameters.
    [HashTable]$headerParameters = @{
        'Content-Type' = "application/x-www-form-urlencoded";
    }

    # Build up the body parameters.
    [HashTable]$bodyParameters = @{
        'grant_type' = "refresh_token";
        'client_id' = $ClientId;
        'client_secret' = $ClientSecret;
        'refresh_token' = $RefreshToken;
    }

    # Build up the web request parameters.
    [HashTable]$requestParameters = @{
        'Uri' = $ApiUri;
        'Method' = "Post";
        'Headers' = $headerParameters;
        'Body' = $bodyParameters;
    }

    $result = Invoke-RestMethod @requestParameters
    if (!$result) {
        throw "No result was returned from '$ApiUrl'"
    }

    Write-Verbose "Token: $($result.access_token)"
    Write-Verbose "Token Type: $($result.token_type)"
    Write-Verbose "Expires in: $($result.expires_in)"
    Write-Verbose "Scope: $($result.scope)"

    return "'$($result.access_token)'"

}